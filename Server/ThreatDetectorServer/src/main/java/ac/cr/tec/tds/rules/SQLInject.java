package ac.cr.tec.tds.rules;

import ac.cr.tec.tds.common.entities.Threat;
import ac.cr.tec.tds.common.entities.Verdict;
import ac.cr.tec.tds.grammars.sql.SQLiteBaseListener;
import ac.cr.tec.tds.grammars.sql.SQLiteLexer;
import ac.cr.tec.tds.grammars.sql.SQLiteParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SQLInject implements Rule{
    @Override
    public Verdict judge(Threat threat) {
        RULE_LOGGER.info(SQLInject.class.getName() + " Analyzing Threat: " + threat);
        if(!threat.getContent().getMessageType().equals(Threat.MESSAGE_TYPE_PLAIN))
            return Verdict.CLEAR;

        boolean match = permute(threat.getContent().getContent())
                .parallelStream()
                .anyMatch(this::parse);

        return match ? Verdict.DANGEROUS : Verdict.CLEAR;
    }

    private List<String> permute(String s){
        s = s.replaceAll("(\\w+);(\\w+)","$1; $2");
        String lowerCase = s.toLowerCase();
        int idx = -1;
        idx = lowerCase.indexOf("select");
        if(idx < 0)
            idx = lowerCase.indexOf("update");
        if(idx < 0)
            idx = lowerCase.indexOf("delete");
        if(idx < 0)
            return Collections.emptyList();
        List<String> stringList = new ArrayList<>();

        String [] matching = s.substring(idx).split(" ");
        StringBuilder ss = new StringBuilder();
        for (int i = 0; i < matching.length; i++) {
            String s1 = matching[i];
            if(i > 0) ss.append(" ");
            ss.append(s1);
            stringList.add(ss.toString());
        }
        return stringList;
    }

    private boolean parse(String message){
        try {
            if(message.split(" ").length < 3)
                return false;
            SQLiteLexer sqLiteLexer = new SQLiteLexer(CharStreams.fromString(message));
            CommonTokenStream tokens = new CommonTokenStream(sqLiteLexer);
            SQLiteParser sqLiteParser = new SQLiteParser(tokens);
            ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
            parseTreeWalker.walk(new SQLiteBaseListener(), sqLiteParser.parse());
            return sqLiteParser.getNumberOfSyntaxErrors() < 1;
        }catch (Exception e){
            return false;
        }
    }
}
