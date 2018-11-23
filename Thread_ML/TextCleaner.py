import nltk
import pandas as pd


SPAM_WORDS=[
    'make','address','all','3d','our',
    'over','remove','internet','order',
    'mail','receive','will','people',
    'report','addresses','free','business',
    'email','you','credit','your','font',
    '000','money','hp','hpl','george','650',
    'lab','labs','telnet','857','data','415',
    '85','technology','1999','parts','pm',
    'direct','cs','meeting','original',
    'project','re','edu','table','conference'
]

SPECIAL_CHARS =[
    ';','(','[','!','$','#'
]


class TextCleaner():
    def __init__(self):
        super().__init__()

    def cointain_words_in_text(self, text, words, special_char):
        text = text.lower()
        text_tokenized = nltk.Text(nltk.word_tokenize(text))
        totaldic = []
        for word in words:
            totaldic.append((text_tokenized.count(word)*100)/len(text_tokenized))
        for char in special_char:
            count=0
            for i in text:
                if char ==i:
                    count += 1
            totaldic.append((count*100)/len(text))
        return [totaldic]
