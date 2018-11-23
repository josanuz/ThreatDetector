from sklearn.externals import joblib
import numpy as np

class Model():

        def __init__(self, model_path):
            self.model_instance = joblib.load(model_path)


        def predict_data(self, panda_dataframe):
            try:
               return self.model_instance.predict(panda_dataframe)
            except:
                return False