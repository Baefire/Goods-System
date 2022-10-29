import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class SeverAchive implements Sever{
    boolean flag = true;
    DaoAchive dao = new DaoAchive();
    public boolean addGoods(Goods g) {
        Iterator print=GoodsData.goods.entrySet().iterator();
        while(print.hasNext())
        {
            Map.Entry entry=(Map.Entry)print.next();
            Goods st = (Goods) entry.getValue();
            if(st.getnum().equals(g.getnum()))
            {flag=false;break;}
        }
        dao.addGoods(g);
        return flag;
    }
    public Vector<Goods> getGoodsLists(){
        return dao.getGoodsLists();
    }
    public Goods searchBynum(String gnum){
        return dao.searchBynum(gnum);
    }
    public Goods searchByname(String gname){
        return dao.searchByname(gname);
    }
    public Vector<Goods> searchBypricerange(float priceHigh, float priceLow){
        return dao.searchBypricerange(priceHigh,priceLow);
    }
    public boolean deleteGoods(String gnum){
        return dao.deleteGoods(gnum);
    }
    public boolean changename(String gnum,String newname){
        return dao.changename(gnum,newname);
    }
    public boolean changeprice(String gnum,float newprice){
        return dao.changeprice(gnum,newprice);
    }
    public boolean changestocks(String gnum,float newstocks){
        return dao.changestocks(gnum,newstocks);
    }
}
