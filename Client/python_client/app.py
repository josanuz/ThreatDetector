from ThreadData import *
from HttpRequest import *
import time
import sys
def main():
    arg=sys.argv
    ht = HttpRequest()
    tData = ThreadData()
    if len(arg) > 1:
        num_messages = int(arg[1])
    else:
        num_messages = 1000
    for i in range(num_messages):
        print('*' * 20+'  Sending Message  '+'*' * 20)
        r = ht.post_request(
            'api/message/',
            tData.data
        )
        time_sleep = random.randrange(0, 3)/18
        print ('Message #: %s\nWait: %ss' % (i+1, time_sleep))
        print ('Headers: %s' % r.headers)
        print('Encoding: %s' % r.encoding)

        # Sleep messages randomly
        time.sleep(time_sleep)


main()