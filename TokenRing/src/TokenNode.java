import org.omg.CORBA.INTERNAL;

/**
 * Created by azhar on 3/9/16.
 */
public class TokenNode {
    public String name;
    public int vertexType;

    TokenNode(){}

    TokenNode(String name, int vertexType){
        this.name=name;
        this.vertexType=vertexType;
    }

    @Override
    public String toString(){
        return name;

    }


    public void executeToken(Token token){


    }

    public void addRequest(Quest q){

    }

    public void executeProxy(Token token){

    }


    public void forwardToken(Token token){


    }

    public void execute_3(Token token){

    }


    public void addToken(Token token){

    }





}
