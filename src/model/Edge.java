package src.model;

/**
 * 边
 *
 * @date 2024/09/05
 */
public class Edge {
    private Integer id; // 边编号
    private Integer Node1Id; // 结点1编号
    private Integer Node2Id; // 结点2编号
    private Integer distance; // 距离

    public Edge(Integer id, Integer node1Id, Integer node2Id, Integer distance) {
        this.id = id;
        this.Node1Id = node1Id;
        this.Node2Id = node2Id;
        this.distance = distance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNode1Id() {
        return Node1Id;
    }

    public void setNode1Id(Integer node1Id) {
        this.Node1Id = node1Id;
    }

    public Integer getNode2Id() {
        return Node2Id;
    }

    public void setNode2Id(Integer node2Id) {
        this.Node2Id = node2Id;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
