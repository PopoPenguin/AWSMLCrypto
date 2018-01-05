package com.codingnomads.AWSMLCrypto.mapper;

import com.codingnomads.AWSMLCrypto.model.Coin;
import com.codingnomads.AWSMLCrypto.model.Data;
import com.codingnomads.AWSMLCrypto.model.PredictCustomPojo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;

@Mapper
public interface TestTableMapper {

    public final String GET_TIME = "select unixtime from data where unixtime = #{time}";
    public final String INSERT_DATA = "insert into data (closevalue, highvalue, lowvalue, openvalue, volumefrom, volumeto, unixtime)" +
            "values (#{close}, #{high}, #{low}, #{open},#{volumeFrom}, #{volumeTo}, #{time})";
    //public final String SELECT_LATEST_TIME = "select unixtime from predictions where unixtime = (select max(unixtime) from data)";
    //for testing:
    public final String SELECT_LATEST_TIME = "select unixtime from predictions where unixtime = (select max(unixtime) from predictions)";
    public final String SELECT_CLOSEVALUE_FROM_LATEST_ENTRY = "select closevalue from datatable where unixtime = (select max(unixtime) from data)";
    public final String INSERT_PREDICT_DATA = "insert into predictions (requestdate, amznrequestid, highValuepredict, coinid, unixtime, modeltypeid, awsmlmodelid) values (#{requestDate}, #{amznRequestId}, #{highValuePredict}, #{coinId}, #{time}, #{modelTypeId}, #{awsMLModelId})";
    public final String GET_COINID = "select coinid from datatable where unixtime = #{time}";
    public final String GET_DATA_BY_COINID = "select * from datatable where coinid = #{coinid}";
    public final String INSERT_COIN_INFO = "insert into coininfo (name, symbol, coinname, fullname) values (#{name}, #{symbol}, #{coinName}, #{fullName})";
    public final String GET_COINID_BY_STRING = "select id from coininfo where name = #{fsym}";
    public final String GET_ALL_COINS = "select * from coininfo";

    public final String UPDATE_HIGHVALUEACTUAL = "update predictions set highvalueactual = #{arg0} where unixtime = #{arg1}";
    public final String SELECT_HIGHVALUEPREDICT = "select highvaluepredict from predictions where unixtime = #{time}";
    public final String SELECT_HIGHVALUEACTUAL = "select highvalue from datatable where unixtime = #{time}";
    public final String UPDATE_PCTERROR = "update predictions set percenterror = #{arg0} where unixtime = #{arg1}";
    public final String SELECT_MODELTYPEID_BY_STRING = "select id from modeltype where name = #{modelType}";

    @Select(GET_TIME)
    public Integer getTime(Integer time);

    @Insert(INSERT_DATA)
    public void insertData(Data data);

    @Select(SELECT_LATEST_TIME)
    public Integer selectLatestTime();

    @Select(GET_DATA_BY_COINID)
    public ArrayList<Data> getDataByCoinID (Integer coinID);

    @Insert(INSERT_COIN_INFO)
    public void insertCoinInfo (Coin coin);

    @Select(GET_COINID_BY_STRING)
    public Integer getCoinIdByString (String fsym);

    @Select(GET_ALL_COINS)
    public ArrayList<Coin> getAllCoins();

    @Select(SELECT_CLOSEVALUE_FROM_LATEST_ENTRY)
    public double selectCloseValueFromLatestEntry();

    @Insert(INSERT_PREDICT_DATA)
    public void insertPredictData(PredictCustomPojo predictResult);

    @Select(GET_COINID)
    public int getCoinId(int time);

    @Update(UPDATE_HIGHVALUEACTUAL)
    public void updateHighValueActual(double arg0, Integer arg1); // arg0 = highValueActual, arg1 = time

    @Select(SELECT_HIGHVALUEPREDICT)
    public double selectHighValuePredict(Integer time);

    @Select(SELECT_HIGHVALUEACTUAL)
    public double selectHighValueActual(Integer time);

    @Update(UPDATE_PCTERROR)
    public void updatePcterror(double arg0, Integer arg1); // arg0 = pctError, arg1 = time

    @Select(SELECT_MODELTYPEID_BY_STRING)
    public int getModelTypeId(String modelType);
}
