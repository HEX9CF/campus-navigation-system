package src.controller;

import src.model.Edge;
import src.model.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PathAlgorithm {
    private static final int INF = Integer.MAX_VALUE; // 定义无穷大，表示不可达的距离
    private List<Edge> edges;

    private HashMap<String,Node> data;
    private ArrayList<String> passingPoints = new ArrayList<>();
    // 寻找最短路径
    public String FindMinestDistance(String startPos,String endPos,ArrayList<String> passingPoints){
        Init();

        Node startNode = data.get(startPos);
        Node endNode = data.get(endPos);
        for(int i = 0 ; i< passingPoints.size();i++){
            this.passingPoints.add(Integer.toString(data.get(passingPoints.get(i)).GetID()));
        }
        return FindPath(startNode.GetID(),endNode.GetID(), this.passingPoints);
    }

    // 初始化
    private void Init(){
        edges = new ArrayList<>();
        ReadDataFromFile();
        TransitionDataForm();
    }

    private void ReadDataFromFile(){
        // 从文件读取数据
        try {
            File file = new File("data/edge.txt"); // 创建文件对象
            Scanner scanner = new Scanner(file); // 读取文件内容

            // 读取每一行并更新邻接矩阵
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim(); // 去除前后空白字符
                if (line.isEmpty()) {
                    continue; // 如果是空行，跳过
                }

                String[] parts = line.split(" ");
                if (parts.length != 3) {
                    System.out.println("行格式不正确: " + line);
                    continue; // 如果格式不正确，跳过该行
                }

                try {
                    int from = Integer.parseInt(parts[0]); // 起始节点
                    int to = Integer.parseInt(parts[1]); // 终止节点
                    int distance = Integer.parseInt(parts[2]); // 距离

//                    graph[from][to] = distance; // 从from到to的距离
//                    graph[to][from] = distance; // 从to到from的距离
                    edges.add(new Edge(edges.size(),from,to,distance));
                } catch (NumberFormatException e) {
                    System.out.println("数字格式不正确: " + line);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("节点编号超出范围: " + line);
                }
            }
            scanner.close(); // 结束读取
        } catch (FileNotFoundException e) {
            System.out.println("文件未找到: " + e.getMessage());
            return; // 如果文件未找到，程序结束，输出文件未找到
        }
    }

    private void TransitionDataForm(){
        data = new HashMap<>();

        //data = new ArrayList<>();
        try{
            File file = new File("data/node.txt"); // 创建文件对象
            Scanner scanner = new Scanner(file); // 读取文件内容

            // 读取每一行并更新邻接矩阵
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim(); // 去除前后空白字符
                if (line.isEmpty()) {
                    continue; // 如果是空行，跳过
                }

                String[] parts = line.split(" ");
                if (parts.length != 2) {
                    System.out.println("行格式不正确: " + line);
                    continue; // 如果格式不正确，跳过该行
                }

                try {
                    data.put(parts[1],new Node(Integer.parseInt(parts[0]),parts[1]));
                } catch (NumberFormatException e) {
                    System.out.println("数字格式不正确: " + line);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("节点编号超出范围: " + line);
                }
            }
            scanner.close(); // 结束读取
        }catch (FileNotFoundException e) {
            System.out.println("文件未找到: " + e.getMessage());
            return; // 如果文件未找到，程序结束，输出文件未找到
        }
    }

    // 传进起始坐标和终点坐标
    private String FindPath(int startPos,int endPos,ArrayList<String> passingPoints){
        int m = passingPoints.size(); // 输入经过点的数量
        int[] intermediatePoints = new int[m]; // 创建数组存储经过的点

        for(int i = 0;i<intermediatePoints.length;i++){
            //System.out.println(passingPoints.get(i));
            intermediatePoints[i] = Integer.parseInt(passingPoints.get(i));
            if(intermediatePoints[i] == startPos){
                i--;
            }
        }

        // 计算最短路径
        List<String> path = new ArrayList<>(); // 存储路径
        Set<Integer> visited = new HashSet<>(); // 存储已访问的节点
        visited.add(startPos); // 将起点标记为已访问
        int totalPathLength = calculateShortestPath(/*graph*/ startPos, intermediatePoints, endPos, path, visited); // 计算最短路径

        // 输出从起点到终点的最短路径
        if (totalPathLength == INF) {
//            System.out.println("从起点到终点没有路径");
            return "从起点到终点没有路径";
        } else {
//            System.out.println("从起点到终点的最短路径为: " + String.join(" -> ", path)); // 输出路径
//            System.out.println("路径总权重为: " + totalPathLength); // 输出路径总权重
            return String.join(" -> ",path);
        }
    }

    // 计算最短路径并返回
    private int calculateShortestPath(/*int[][] graph*/ int start, int[] intermediatePoints, int end, List<String> path, Set<Integer> visited) {
        int totalPathLength = 0; // 初始化总路径长度
        int currentPoint = start; // 当前点初始化为起点

        // 遍历经过的点
        for (int point : intermediatePoints) {
            if (visited.contains(point)) {
                continue; // 如果已经访问过，跳过
            }

            // 计算当前点到经过点的最短路径
            int pathLength = dijkstra(/*graph,*/ currentPoint, point, path, visited);
            if (pathLength == INF) {
                System.out.println("没有从 " + currentPoint + " 到 " + point + " 的路径");
                return INF; // 返回无穷大，表示没有路径
            } else {
                totalPathLength += pathLength; // 更新总路径长度
                visited.add(point); // 标记为已访问
                currentPoint = point; // 更新当前点
            }
        }

        // 计算从最后一个经过点到终点的路径
        int finalPathLength = dijkstra(/*graph,*/ currentPoint, end, path, visited);
        if (finalPathLength == INF) {
            System.out.println("没有从 " + currentPoint + " 到 " + end + " 的路径");
            return INF; // 返回无穷大，表示没有路径
        } else {
            totalPathLength += finalPathLength; // 更新总路径长度
        }

        return totalPathLength; // 返回总路径长度
    }

    // 算法
    private int dijkstra(/*int[][] graph,*/ int start, int end, List<String> path, Set<Integer> visited) {
        int n = edges.size(); // 获取节点数量
        boolean[] visitedNodes = new boolean[n]; // 记录节点是否被访问
        int[] distances = new int[n]; // 存储从起点到各节点的距离
        int[] previous = new int[n]; // 记录前驱节点
        Arrays.fill(distances, INF); // 将距离初始化为无穷大
        distances[start] = 0; // 起点到自己的距离为0

        // Dijkstra算法主体
        for (int i = 0; i < n; i++) {
            int u = findMinDistance(distances, visitedNodes); // 找到未访问节点中距离最小的节点
            visitedNodes[u] = true; // 标记该节点为已访问

            // 更新邻接节点的距离
            for(Edge edge : edges){
                if (edge.getNode1Id() == u || edge.getNode2Id() == u) {
                    int v = (edge.getNode1Id() == u) ? edge.getNode2Id() : edge.getNode1Id();
                    if (!visitedNodes[v] && edge.getDistance() != INF && distances[u] != INF && distances[u] + edge.getDistance() < distances[v]) {
                        distances[v] = distances[u] + edge.getDistance(); // 更新距离
                        previous[v] = u; // 更新前驱节点
                    }
                }
            }
        }

        // 没有直接路劲，重建路径
        if (distances[end] != INF) {
            int current = end; // 从终点开始
            List<String> tempPath = new ArrayList<>(); // 临时路径
            while (current != start) {
                //String key = data.get(Integer.toString(current));
                String key = GetName(current);
                tempPath.add(0, key /*" (权重: " + graph[previous[current]][current] + ")"*/); // 添加节点和权重
                current = previous[current]; // 更新当前节点为前驱节点
            }
            //String key = data.get(Integer.toString(start));
            String key = GetName(start);
            tempPath.add(0, key /*" (权重: 0)"*/); // 添加起点

            // 添加到最终路径时，确保不重复
            for (String node : tempPath) {
                String nodeId = node.split(" ")[0]; // 获取节点ID
                if (path.isEmpty() || !path.get(path.size() - 1).startsWith(nodeId)) {
                    path.add(node); // 添加到路径
                }
            }
        }

        return distances[end]; // 返回从起点到终点的距离
    }

    // 寻找
    private static int findMinDistance(int[] distances, boolean[] visited) {
        int min = INF; // 初始化最小值为无穷大
        int minIndex = -1; // 初始化最小值索引

        // 找到未访问节点中距离最小的节点
        for (int i = 0; i < distances.length; i++) {
            if (!visited[i] && distances[i] <= min) {
                min = distances[i]; // 更新最小值
                minIndex = i; // 更新最小值索引
            }
        }

        return minIndex; // 返回最小值索引
    }

    public String GetName(Integer id){
        for (Map.Entry<String, Node> entry : data.entrySet()) {
            Node node = entry.getValue();
            if(node.GetID().equals(id)){
                return node.GetName();
            }
        }
        return "";
    }
}
