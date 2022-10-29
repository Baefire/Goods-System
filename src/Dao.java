import java.util.Vector;

public interface Dao {
    void addGoods(Goods g);
    Vector<Goods> getGoodsLists();
    Goods searchBynum(String gnum);
    Goods searchByname(String gname);
    Vector<Goods> searchBypricerange(float priceHigh, float priceLow);
    boolean deleteGoods(String gnum);
    boolean changename(String gnum, String newname);
    boolean changeprice(String gnum, float newprice);
    boolean changestocks(String gnum, float newstocks);
}
