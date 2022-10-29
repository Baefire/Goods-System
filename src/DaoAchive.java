import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class DaoAchive implements Dao{
    public void addGoods(Goods g) {
        GoodsData.goods.put(g.getnum(),g);
    }
    public Vector<Goods> getGoodsLists() {
        Vector<Goods> send = new Vector<>();
        for (Map.Entry<String, Goods> stringGoodsEntry : GoodsData.goods.entrySet()) {
            Goods st = (Goods) ((Map.Entry) stringGoodsEntry).getValue();
            send.add(st);
        }
        return send;
    }
    public Goods searchBynum(String gnum) {
        for (Map.Entry<String, Goods> stringGoodsEntry : GoodsData.goods.entrySet()) {
            Goods st = (Goods) ((Map.Entry) stringGoodsEntry).getValue();
            if (st.getnum().equalsIgnoreCase(gnum)) {
                return st;
            }
        }
        return  null;
    }
    public Goods searchByname(String gname) {
        GoodsData data = new GoodsData();
        Iterator print=data.goods.entrySet().iterator();
        while(print.hasNext())
        {
            Map.Entry entry=(Map.Entry)print.next();
            Goods st = (Goods) entry.getValue();
            if(st.getname().equalsIgnoreCase(gname))
            {
                return st;
            }
        }
        return null;
    }
    public Vector<Goods> searchBypricerange(float priceHigh, float priceLow) {
        boolean flag = true;
        Vector<Goods> send = new Vector<>();
        GoodsData data = new GoodsData();
        Iterator print = data.goods.entrySet().iterator();
        while(print.hasNext())
        {
            Map.Entry entry=(Map.Entry)print.next();
            Goods st = (Goods) entry.getValue();
            if(st.getprice()<=priceHigh&&st.getprice()>=priceLow)
            {
                send.add(st);
                flag = false;
            }
        }
        if(!flag) return send;
        else return null;
    }
    public boolean deleteGoods(String gnum) {
        boolean flag = false;
        GoodsData data = new GoodsData();
        Iterator print=data.goods.entrySet().iterator();
        while(print.hasNext())
        {
            Map.Entry entry=(Map.Entry)print.next();
            Goods st = (Goods) entry.getValue();
            if(st.getnum().equalsIgnoreCase(gnum))
            {
                data.goods.remove(st.getnum());
                flag = true;
                break;
            }
        }
        return flag;
    }
    public boolean changename(String gnum,String newname) {
        boolean flag = false;
        GoodsData data = new GoodsData();
        Iterator print=data.goods.entrySet().iterator();
        while(print.hasNext())
        {
            Map.Entry entry=(Map.Entry)print.next();
            Goods st = (Goods) entry.getValue();
            if(st.getnum().equalsIgnoreCase(gnum))
            {
                st.setname(newname);
                flag = true;
            }
        }
        return flag;
    }
    public boolean changeprice(String gnum,float newprice) {
        boolean flag = false;
        GoodsData data = new GoodsData();
        Iterator print=data.goods.entrySet().iterator();
        while(print.hasNext())
        {
            Map.Entry entry=(Map.Entry)print.next();
            Goods st = (Goods) entry.getValue();
            if(st.getnum().equalsIgnoreCase(gnum))
            {
                st.setprice(newprice);
                flag = true;
            }
        }
        return flag;
    }
    public boolean changestocks(String gnum,float newstocks) {
        boolean flag = false;
        GoodsData data = new GoodsData();
        Iterator print=data.goods.entrySet().iterator();
        while(print.hasNext())
        {
            Map.Entry entry=(Map.Entry)print.next();
            Goods st = (Goods) entry.getValue();
            if(st.getnum().equalsIgnoreCase(gnum))
            {
                st.setstocks(newstocks);
                flag = true;
            }
        }
        return flag;
    }
}
