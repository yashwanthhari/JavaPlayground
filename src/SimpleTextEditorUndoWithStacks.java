import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SimpleTextEditorUndoWithStacks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Character> string = new Stack<>();
        Stack<Object> stack = new Stack<>();
        while (n-- > 0) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "1":
                    for (int i = 0; i < input[1].length(); i++) {
                        string.push(input[1].charAt(i));
                    }
                    stack.push(input[1].length());
                    break;
                case "2":
                    int k = Integer.parseInt(input[1]);
                    Stack<Character> undo = new Stack<>();
                    for (int i = 0; i < k; i++) {
                        undo.push(string.pop());
                    }
                    stack.push(undo);
                    break;
                case "3":
                    int l = Integer.parseInt(input[1]);
                    if (l < 0 || l > string.size()) break;
                    System.out.println(string.get(l - 1));
                    break;
                case "4":
                    if (stack.isEmpty()) break;
                    Object state = stack.pop();
                    if (state instanceof Integer) {
                        int j = (Integer) state;
                        for (int i = 0; i < j; i++) {
                            string.pop();
                        }
                    } else {
                        undo = (Stack) state;
                        while (!undo.isEmpty()) {
                            string.push(undo.pop());
                        }
                    }
                    break;
            }
        }
    }

}

