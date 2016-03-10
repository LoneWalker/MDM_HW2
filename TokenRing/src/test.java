/**
 * Created by xc9pd on 3/9/2016.
 */
public class test {

    public static void main(String[] arg){

        MobilSupportServer mss1=new MobilSupportServer("MSS_1");
        MobilSupportServer mss2=new MobilSupportServer("MSS_2");
        MobilSupportServer mss3=new MobilSupportServer("MSS_3");
        MobilSupportServer mss4=new MobilSupportServer("MSS_4");
        MobilSupportServer mss5=new MobilSupportServer("MSS_5");

        mss1.successor=mss2;
        mss2.successor=mss3;
        mss3.successor=mss4;
        mss4.successor=mss5;
        mss5.successor=mss1;
        MobilHost mh1=new MobilHost("MH_1");
        MobilHost mh2=new MobilHost("MH_2");
        MobilHost mh3=new MobilHost("MH_3");
        MobilHost mh4=new MobilHost("MH_4");
        MobilHost mh5=new MobilHost("MH_5");
        mh1.moveTo(mss1);
        mh2.moveTo(mss2);
        mh3.moveTo(mss3);
        mh4.moveTo(mss4);
        mh5.moveTo(mss5);

        Token tk=new Token(mss1);

        mh1.submitRequest("a");
        mh2.submitRequest("b");
        mh3.submitRequest("c");
        mh4.submitRequest("d");
        mh5.submitRequest("e");

        mss1.addToken(tk);
        tk.executeToken();
        tk.executeToken();
        System.out.println("end?");







    }
}
