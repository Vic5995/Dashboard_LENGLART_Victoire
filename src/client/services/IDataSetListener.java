package client.services;

import model.ServerDataSet;

public interface IDataSetListener {

  void onReceivedGeneralDataSet(ServerDataSet dataSet);
}
