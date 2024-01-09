package ru.nsu.fit.exercises;

public class Number1 {
    public static int[][] identityMatrix(int n) {
        int[][] result = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i==j) {
                    result[i][j] = 1;
                }
            }
        }
        return result;
    } // Оцените сложность следующего метода: сложность O(n^2)
    public static int[][] myIdentityMatrix(int n) {
        int[][] result = new int[n][n];
        for (int i=0; i<n; i++) {
                    result[i][i] = 1;
        }
        return result;
    } // Можно ли сделать его более эффективным без изменения результатов? сложность n
    // 3. Если вы смогли предложить более эффективную версию, будет ли она обладать меньшей сложностью?
    // Нет, поскольку n^2 инициализирует массив.
}
