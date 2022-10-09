
#include <stdlib.h>
#include <string.h>

int main(void) {
    return 0;
}

static int exists_i(char** board, int boardSize, int* boardColSize, char* word, size_t wordLength, int ci, int bx, int by, int* usedChars) {
    int mask = 1 << by;
    char* row = board[bx];
    if ((usedChars[bx] & mask) != 0) {
        return 0;
    }
    if (word[ci] != row[by]) {
        return 0;
    }

    int nextCi = ci + 1;
    if (nextCi >= wordLength) {
        return 1;
    }
    usedChars[bx] = usedChars[bx] | mask;
    int exists = (by + 1 < boardColSize[bx] && exists_i(board, boardSize, boardColSize, word, wordLength, nextCi, bx, by + 1, usedChars)) ||
                 (by - 1 >= 0 && exists_i(board, boardSize, boardColSize, word, wordLength, nextCi, bx, by - 1, usedChars)) ||
                 (bx + 1 < boardSize && exists_i(board, boardSize, boardColSize, word, wordLength, nextCi, bx + 1, by, usedChars)) ||
                 (bx - 1 >= 0 && exists_i(board, boardSize, boardColSize, word, wordLength, nextCi, bx - 1, by, usedChars));
    if (!exists) {
        usedChars[bx] = (usedChars[bx] & (~mask));
    }
    return exists;
}

static int exists(char** board, int boardSize, int* boardColSize, char* word, size_t wordLength) {
    if (wordLength <= 0) {
        return 1;
    }
    char head = word[0];
    int i, j, k;
    int usedChars[boardSize];
    for (i = 0; i < boardSize; i++) {
        for (j = 0; j < boardColSize[i]; j++) {
            if (board[i][j] == head) {
                for (k = 0; k < boardSize; k++) {
                    usedChars[k] = 0;
                }
                if (exists_i(board, boardSize, boardColSize, word, wordLength, 0, i, j, usedChars)) {
                    return 1;
                }
            }
        }
    }
    return 0;
}

char** findWords(char** board, int boardSize, int* boardColSize, char** words, int wordsSize, int* returnSize) {
    char* tmp[wordsSize];

    int i = 0;
    int resSize = 0;

    for (i = 0; i < wordsSize; i++) {
        char* word = words[i];
        if (exists(board, boardSize, boardColSize, word, strlen(word))) {
            tmp[resSize++] = word;
        }
    }

    *returnSize = resSize;
    
    char **res = (char **)malloc(sizeof(char *) * resSize);
    for (i = 0; i < resSize; i ++) {
        res[i] = tmp[i];
    }

    return res;
}