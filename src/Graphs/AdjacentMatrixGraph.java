import java.util.ArrayList;

public class AdjacentMatrixGraph {
    ArrayList<String> vertices = new ArrayList<>();
    int[][] adjacentMatrix;

    AdjacentMatrixGraph(){
        adjacentMatrix=new int[1][1];
    }


    public int getVerticesSize(){
        return vertices.size();
    }


    public void addVertex(String value){
        vertices.add(value.toLowerCase());
        int v = getVerticesSize();
        if (v >= adjacentMatrix.length){
            int[][] newAdjacentMatrix = new int[v*2][v*2];
            for (int i=0; i<adjacentMatrix.length; i++){
                for (int j = 0; j < adjacentMatrix.length ; j++) {
                    newAdjacentMatrix[i][j] = adjacentMatrix[i][j];
                }
            }
            adjacentMatrix = newAdjacentMatrix;
        }
    }

    public void addEdge(String startEgde,String endEdge){
        try{
            adjacentMatrix[vertices.indexOf(startEgde.toLowerCase())][vertices.indexOf(endEdge.toLowerCase())] = 1;
        }catch (Exception e){
            System.out.println("Invalid Edges");
        }
    }

     public void removeEdge(String startEgde,String endEdge){
        try{
            adjacentMatrix[vertices.indexOf(startEgde.toLowerCase())][vertices.indexOf(endEdge.toLowerCase())] = 0;
        }catch (Exception e){
            System.out.println("Invalid Edges");
        }
    }
    public int outgoingNeighbours(String value){
        int neighbourCount = 0;
        try{
            for (int idx = 0; idx < adjacentMatrix.length; idx++) {
            neighbourCount += adjacentMatrix[vertices.indexOf(value.toLowerCase())][idx];
        }
        }catch (Exception e){
           System.out.println("Invalid Edge");
       }
       return neighbourCount;
    }

    public int incomingNeighbours(String value){
        int neighbourCount = 0;
       try {
           for (int i = 0; i < adjacentMatrix.length; i++) {
               neighbourCount += adjacentMatrix[i][vertices.indexOf(value.toLowerCase())];
           }
       }catch (Exception e){
           System.out.println("Invalid Edge");
       }
        return neighbourCount;
    }


}
