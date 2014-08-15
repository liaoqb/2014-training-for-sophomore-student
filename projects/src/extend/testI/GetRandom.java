  // <Copyright liaoqb>  [Copyright 2014.08.12]
import java.io.IOException;
import jigsaw.*;
import java.io.*;
import jigsaw.Jigsaw;
import jigsaw.JigsawNode;

public class GetRandom {
  private static JigsawNode destNode = new JigsawNode(new int[]{25,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,0});
  public static void main(String[] args) throws IOException {
    DataOutputStream fout = new DataOutputStream(new FileOutputStream("random.txt"));

    for (int i = 0; i < 50; ++i) {
      JigsawNode startNode = Jigsaw.scatter(destNode, 1000);

      int[] nodeState = startNode.getNodesState();

      for (int j = 0; j < nodeState.length; ++j) {
        fout.writeInt(nodeState[j]);
      }
    }
    fout.close();

    fout = new DataOutputStream(new FileOutputStream("count.txt"));
    fout.writeInt(0);
    fout.close();
  }
}
