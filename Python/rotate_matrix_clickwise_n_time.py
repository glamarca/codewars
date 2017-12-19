def __rotate_once(matrix):
    result = matrix
    if matrix:
        result = [
            [list(reversed(matrix[j]))[i] for j, val_j in enumerate(matrix[i])]
            for i, val_i in enumerate(matrix)
        ]
    return result


def rotate_against_clockwise(matrix, count=1):
    result = matrix
    if matrix:
        for i in range(count % 4):
            result = __rotate_once(result)
    return result


def is_valid_matrix(matrix):
    return not [len(line) for line in matrix if len(line) != len(matrix)]