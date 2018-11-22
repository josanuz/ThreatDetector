#!/usr/bin/env python
import ipaddr
import random

PROTOCOLS = ['HTTP', 'POP3', 'IMAP']
MESSAGE_TYPE = ['Mail','HTTP Request']

class ThreadData():

    def __init__(self):
        self._data = {}

    @property
    def data(self):
        self._data['originIp'] = self.random_ip_addr()
        self._data['destinationIP'] = self.random_ip_addr()
        self._data['headers'] = self.headers()
        self._data['protocol'] = self.random_protocol()
        self._data['length'] = self.lenght()
        self._data['content'] = self.content()
        return self._data

    def random_protocol(self):
        return PROTOCOLS[random.randrange(0, len(PROTOCOLS))]

    def random_message_type(self):
        return MESSAGE_TYPE[random.randrange(0, len(MESSAGE_TYPE))]

    def random_ip_addr(self):
        return '%s.%s.%s.%s' % (
            random.randrange(0, 255),
            random.randrange(0, 255),
            random.randrange(0, 255),
            random.randrange(0, 255)
        )

    # Properties




    def headers(self):
        return [
            {
                "headerName": "Accept",
                "headerValue": "application/json"
            },
            {
                "headerName": "Content Type",
                "headerValue": "application/json"
            },
            {
                "headerName": "User Agent",
                "headerValue": "SpringTestJUnit/CURL"
            },
            {
                "headerName": "Forwarder",
                "headerValue": "0.0.0.0"
            },
            {
                "headerName": "Host",
                "headerValue": "Local Host"
            }
        ]



    def lenght(self):
        return random.randrange(150,650)


    def content(self):
        return {
            "messageType": "HTTP Request",
            "content": "GET /api/messages?url=SELECT%20*%20FROM%20USER%20WHERE%20TRUE%3B"
        }
    def required(self):
        return ["orginIp", "headers", "destinationIP", "protocol", "lenght", "content"]
