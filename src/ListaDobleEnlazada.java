public class ListaDobleEnlazada {
    private Nodo Cabeza;
    private Nodo Cola;
    public ListaDobleEnlazada(){
        Cabeza=null;
        Cola=null;
    }


    public void add(int data){
        if(this.Cabeza==null && this.Cola==null){
            this.Cabeza=new Nodo(data);
            this.Cola=this.Cabeza;
        }else{
            Nodo current = this.Cabeza;
            Cabeza=new Nodo(data);
            Cabeza.next=current;
            current.prev=Cabeza;
        }
    }

    public void delete(int data){
        Nodo current = this.Cabeza;
        while (current!=null){
            if (current!=Cabeza && current!=Cola && current.data==data){
                current.prev.next=current.next;
                current.next.prev=current.prev;
            }
            if (current==Cabeza && current!=Cola && current.data==data){
                current.next.prev=null;
                Cabeza=current.next;
                current.next=null;
            }
            if (current==Cola && current!=Cabeza && current.data==data){
                current.prev.next=null;
                Cola=current.prev;
            }
            current=current.next;
        }
    }

    public Nodo getNodo(int data){
        Nodo current = Cabeza;
        while (current.data!=data){
            current=current.next;
        }
        return current;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        Nodo current = Cabeza;
        while (current!=null){
            sb.append(current.data).append("-");
            current=current.next;
        }
        return sb.toString();
    }

    class Nodo{
        Nodo next;
        Nodo prev;
        int data;
        Nodo(int data){
            this.data=data;
            next=null;
            prev=null;
        }
    }
}
