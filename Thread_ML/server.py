from flask import Flask, request, json
from AntiSpam import AntiSpam
from Model import Model
from TextCleaner import TextCleaner, SPECIAL_CHARS, SPAM_WORDS
app = Flask(__name__)


#######################################################

def success(output):
    data = {
        'output':output,
        'message': 'success'
    }
    return app.response_class(
        response=json.dumps(data),
        mimetype='application/json'
    )

def error():
    data = {
        'output':{},
        'message': 'success'
    }
    return app.response_class(
        response=json.dumps(data),
        mimetype='application/json'
    )

###################################################################
@app.route('/api/is_spam', methods = ['GET', 'POST'])
def is_spam():
    if request.method == 'GET':
        return success({})
    if request.method == 'POST':
        #Recived data
        data = request.get_json(force=True)
        print(data)
        if 'text' in data:
            lala=TextCleaner()
            dic= lala.cointain_words_in_text(
                'Confirm wants us to unsubscribe, too',
                SPAM_WORDS,
                SPECIAL_CHARS
            )

            m = Model('random_forest.joblib')
            response = {'is_soam': int(m.predict_data(dic)[0])}
            return success(response)
        else:
            return error()


@app.route('/api/antispam', methods = ['GET', 'POST'])
def antispam():
    an = AntiSpam()
    if request.method == 'GET':
        return success({})
    if request.method == 'POST':
        #Recived data
        data = request.get_json(force=True)
        response = None
        if 'text' in data:
            response = an.is_spam(data['text'])
            return success(response)
        else:
            return error()


if __name__ == '__main__':
    # run app in debug mode on port 5000
    app.run(debug=True, port=5000)