package src.model;

/**
 * 结点
 *
 * @date 2024/09/05
 */
public class Node {
    private Integer id; // 结点编号
    private String name; // 结点名称

    public Node(Integer id,String name){
        this.id = id;
        this.name = name;
    }

    public Integer GetID(){
        return id;
    }

    public String GetName(){
        return name;
    }
}
