package client.services;

import model.Promotion;
import model.serverDataSet.FILDataSet;
import model.serverDataSet.FISEDataSet;
import model.serverDataSet.FITDataSet;
import model.serverDataSet.ServerDataSet;

/**
 * Interface : IDataSetListener
 *
 *  -> permet de signaler au dashboard la réception de nouvelles données pour qu'il puisse générer son affichage
 *
 * @see client.main.Dashboard
 */
public interface IDataSetListener {

  void onReceivedGeneralDataSet(ServerDataSet dataSet);

  void onReveivedPromotionsDataSet(ServerDataSet dataSet);

  void onReceivedFILDataSet(FILDataSet dataSet);

  void onReceivedFITDataSet(FITDataSet dataSet);

  void onReceivedFISEDataSet(FISEDataSet dataSet);

  void onReceivedPromotion(Promotion promotion);
}
