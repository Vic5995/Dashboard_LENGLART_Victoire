package client.services;

import model.serverDataSet.FILDataSet;
import model.serverDataSet.FISEDataSet;
import model.serverDataSet.FITDataSet;
import model.serverDataSet.ServerDataSet;

public interface IDataSetListener {

  void onReceivedGeneralDataSet(ServerDataSet dataSet);

  void onReveivedPromotionsDataSet(ServerDataSet dataSet);

  void onReceivedFILDataSet(FILDataSet dataSet);

  void onReceivedFITDataSet(FITDataSet dataSet);

  void onReceivedFISEDataSet(FISEDataSet dataSet);
}
