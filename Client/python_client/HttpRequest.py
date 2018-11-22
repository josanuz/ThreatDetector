from dotenv import load_dotenv
import requests as req
import os

class HttpRequest():

    def __init__(self):
        load_dotenv()



    def post_request(self, url, data):
        response = req.post(
            os.getenv('host')+':'+os.getenv('port')+'/'+url,
            json=data
        )
        return response




