

import state.StateContext;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by liyuntao on 2014/10/30.
 */
public class CommentRemoveMain {
    private static void removeComment(String filePath) throws IOException {
        FileReader fr = new FileReader(filePath);
        int ch = 0;
        StateContext sc = new StateContext();
        while((ch = fr.read())!=-1 ) {
            sc.changeState((char)ch);
        }
    }

    public static void main(String[] args) throws IOException {
        removeComment("/Users/amour/IdeaProjects/JavaCommentRemover/FileForTest.txt");
    }
}
