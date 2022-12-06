package DataSructures.Stackzz;

import java.util.Stack;

// the idea is remove all the persons from the list who fails the case of knowing persons.
// after all the process there will be one left. and check if it's row has all 0 and col has all 1 except for itself.
public class CelebrityProblem {

    int celebrity(int arr[][], int n) {
        
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            st.add(i);
        }

        // this removes all the normal persons.
        while (st.size() > 1) {
            int a = st.pop();
            int b = st.pop();

            // if a knows b then a is sure not going to be the celebrity.
            if (knows(arr, a, b)) {
                st.add(b);
            } else {
                // if not then it can be a potential celebrity.
                st.add(a);
            }
        }

        int potential = st.pop();
        int countZero = 0;
        // check for it's row all should be zero.
        for (int i = 0; i < n; i++) {
            if (arr[potential][i] == 0) countZero++;
        }
        if (countZero != n) return -1;
        // check it's columns all should be 1 except the celebrity row. since the person does not know itself.
        int countOne = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i][potential] == 1) countOne++;
        }
        if (countOne != n - 1) return -1;

        return potential;
    }

    private boolean knows(int[][] arr, int a, int b) {
        return arr[a][b] == 1;
    }
}
