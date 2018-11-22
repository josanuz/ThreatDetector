from flask import Flask, request, json
from AntiSpam import AntiSpam

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
        return success(data)


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