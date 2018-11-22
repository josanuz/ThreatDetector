import antispam as antisp


class AntiSpam():

    def __init__(self):
        pass

    def is_spam(self, text):
        return {
            'score': antisp.score(text),
            'is_spam': int(antisp.is_spam(text))
        }

