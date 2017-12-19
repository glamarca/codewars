from random import randint
from unittest import TestCase
from rotate_matrix_clickwise_n_time import rotate, is_valid_matrix


class TestRotate(TestCase):

    def test_rotate_once_None(self):
        matrix = None
        expected = None
        self.assertEqual(expected, rotate(matrix))

    def test_rotate_once_Empty(self):
        matrix = [[]]
        expected = [[]]
        self.assertEqual(expected, rotate(matrix))

    def test_rotate_once_sigleton(self):
        matrix = [[5]]
        expected = [[5]]
        self.assertEqual(expected, rotate(matrix))

    def test_valid_matrix(self):
        valid_matrix = [[1, 2, 3], [1, 2, 3], [1, 2, 3]]
        invalid_matrix = [[1, 2, 3], [1, 2, 3]]
        self.assertTrue(is_valid_matrix(valid_matrix))
        self.assertFalse(is_valid_matrix(invalid_matrix))

    def test_rotate_once_2x2(self):
        matrix = [[1, 2], [1, 2]]
        expected = [[2, 2], [1, 1]]
        self.make_test_matrix(expected, matrix, 2)

    def test_rotate_once_3x3(self):
        matrix = [[1, 2, 3], [1, 2, 3], [1, 2, 3]]
        expected = [[3, 3, 3], [2, 2, 2], [1, 1, 1]]
        self.make_test_matrix(expected, matrix, 3)

    def test_rotate_once_nxn(self):
        matrix = [[1, 2, 3], [1, 2, 3], [1, 2, 3]]
        expected = [[3, 3, 3], [2, 2, 2], [1, 1, 1]]
        self.assertEqual(expected, rotate(matrix))
        for i in range(5, 100):
            matrix, expected = self.make_matrix_and_expected_rotate(n=i, rotation_count=1)
            self.make_test_matrix(expected, matrix, i)

    def make_test_matrix(self, expected, matrix, n, rotation_count=1):
        try:
            print("Test on matrix {} x {}".format(n, n))
            self.assertEqual(expected, rotate(matrix, rotation_count))
        except Exception as e:
            print("Test fail on matrix {}".format(matrix))
            raise e

    def test_rotate_n_None(self):
        matrix = None
        expected = None
        for i in range(0, 10):
            self.assertEqual(expected, rotate(matrix, i))

    def test_rotate_n_Empty(self):
        matrix = [[]]
        expected = [[]]
        for i in range(0, 10):
            self.assertEqual(expected, rotate(matrix, i))

    def test_rotate_n_2x2(self):
        for i in range(1, 10):
            matrix, expected = self.make_matrix_and_expected_rotate(n=2, rotation_count=i)
            self.assertEqual(expected, rotate(matrix, i))

    def test_rotate_n_3x3(self):
        for i in range(1, 10):
            matrix, expected = self.make_matrix_and_expected_rotate(n=3, rotation_count=i)
            self.assertEqual(expected, rotate(matrix, i))

    def test_rotate_n_nxn(self):
        for x in range(5, 50):
            for i in range(1, 10):
                matrix, expected = self.make_matrix_and_expected_rotate(n=x, rotation_count=i)
                self.make_test_matrix(expected=expected, matrix=matrix, n=x, rotation_count=i)


    def make_matrix_and_expected_rotate(self, n=None, rotation_count=None):
        if not n:
            n = randint(5, 50)
        if not rotation_count:
            rotation_count = randint(1, 30)
        real_count = rotation_count % 4
        if real_count == 1:
            matrix = [[i+1 for i in range(0, n)] for j in range(0, n)]
            expected = [[n-j for i in range(0, n)] for j in range(0, n)]

        elif real_count == 2:
            matrix = [[i+1 for i in range(0, n)] for j in range(0, n)]
            expected = [[n-i for i in range(0, n)] for j in range(0, n)]

        elif real_count == 3:
            matrix = [[i+1 for i in range(0, n)] for j in range(0, n)]
            expected = [[j+1 for i in range(0, n)] for j in range(0, n)]

        elif real_count == 0:
            matrix = [[i+1 for i in range(0, n)] for j in range(0, n)]
            expected = [[i+1 for i in range(0, n)] for j in range(0, n)]

        return matrix, expected

    def test_make_matrix_and_expected_rotate_once(self):
        expected_matrix = [[1, 2], [1, 2]]
        expected_rotate = [[2, 2], [1, 1]]
        matrix, rotated = self.make_matrix_and_expected_rotate(2, 1)
        self.assertEqual(expected_matrix, matrix, "expected_matrix")
        self.assertEqual(expected_rotate, rotated, "expected_rotate")
        expected_matrix = [[1, 2, 3], [1, 2, 3], [1, 2, 3]]
        expected_rotate = [[3, 3, 3], [2, 2, 2], [1, 1, 1]]
        matrix, rotated = self.make_matrix_and_expected_rotate(3, 1)
        self.assertEqual(expected_matrix, matrix, "expected_matrix")
        self.assertEqual(expected_rotate, rotated, "expected_rotate")
        expected_matrix = [[1, 2, 3, 4], [1, 2, 3, 4], [1, 2, 3, 4], [1, 2, 3, 4]]
        expected_rotate = [[4, 4, 4, 4], [3, 3, 3, 3], [2, 2, 2, 2], [1, 1, 1, 1]]
        matrix, rotated = self.make_matrix_and_expected_rotate(4, 1)
        self.assertEqual(expected_matrix, matrix, "expected_matrix")
        self.assertEqual(expected_rotate, rotated, "expected_rotate")

    def test_make_matrix_and_expexted_rotate_n(self):
        expected_matrix = [[1, 2], [1, 2]]
        expected_rotate = [[2, 1], [2, 1]]
        matrix, rotated = self.make_matrix_and_expected_rotate(2, 2)
        self.assertEqual(expected_matrix, matrix, "expected_matrix")
        self.assertEqual(expected_rotate, rotated, "expected_rotate")
        expected_matrix = [[1, 2, 3], [1, 2, 3], [1, 2, 3]]
        expected_rotate = [[3, 2, 1], [3, 2, 1], [3, 2, 1]]
        matrix, rotated = self.make_matrix_and_expected_rotate(3, 2)
        self.assertEqual(expected_matrix, matrix, "expected_matrix")
        self.assertEqual(expected_rotate, rotated, "expected_rotate")
        expected_matrix = [[1, 2, 3, 4], [1, 2, 3, 4], [1, 2, 3, 4], [1, 2, 3, 4]]
        expected_rotate = [[4, 3, 2, 1], [4, 3, 2, 1], [4, 3, 2, 1], [4, 3, 2, 1]]
        matrix, rotated = self.make_matrix_and_expected_rotate(4, 2)
        self.assertEqual(expected_matrix, matrix, "expected_matrix")
        self.assertEqual(expected_rotate, rotated, "expected_rotate")
        expected_matrix = [[1, 2, 3, 4], [1, 2, 3, 4], [1, 2, 3, 4], [1, 2, 3, 4]]
        expected_rotate = [[4, 3, 2, 1], [4, 3, 2, 1], [4, 3, 2, 1], [4, 3, 2, 1]]
        matrix, rotated = self.make_matrix_and_expected_rotate(4, 10)
        self.assertEqual(expected_matrix, matrix, "expected_matrix")
        self.assertEqual(expected_rotate, rotated, "expected_rotate")

        expected_matrix = [[1, 2], [1, 2]]
        expected_rotate = [[1, 1], [2, 2]]
        matrix, rotated = self.make_matrix_and_expected_rotate(2, 3)
        self.assertEqual(expected_matrix, matrix, "expected_matrix")
        self.assertEqual(expected_rotate, rotated, "expected_rotate")
        expected_matrix = [[1, 2, 3], [1, 2, 3], [1, 2, 3]]
        expected_rotate = [[1, 1, 1], [2, 2, 2], [3, 3, 3]]
        matrix, rotated = self.make_matrix_and_expected_rotate(3, 3)
        self.assertEqual(expected_matrix, matrix, "expected_matrix")
        self.assertEqual(expected_rotate, rotated, "expected_rotate")
        expected_matrix = [[1, 2, 3, 4], [1, 2, 3, 4], [1, 2, 3, 4], [1, 2, 3, 4]]
        expected_rotate = [[1, 1, 1, 1], [2, 2, 2, 2], [3, 3, 3, 3], [4, 4, 4, 4]]
        matrix, rotated = self.make_matrix_and_expected_rotate(4, 3)
        self.assertEqual(expected_matrix, matrix, "expected_matrix")
        self.assertEqual(expected_rotate, rotated, "expected_rotate")
        expected_matrix = [[1, 2, 3, 4], [1, 2, 3, 4], [1, 2, 3, 4], [1, 2, 3, 4]]
        expected_rotate = [[1, 1, 1, 1], [2, 2, 2, 2], [3, 3, 3, 3], [4, 4, 4, 4]]
        matrix, rotated = self.make_matrix_and_expected_rotate(4, 11)
        self.assertEqual(expected_matrix, matrix, "expected_matrix")
        self.assertEqual(expected_rotate, rotated, "expected_rotate")

        expected_matrix = [[1, 2], [1, 2]]
        expected_rotate = [[1, 2], [1, 2]]
        matrix, rotated = self.make_matrix_and_expected_rotate(2, 4)
        self.assertEqual(expected_matrix, matrix, "expected_matrix")
        self.assertEqual(expected_rotate, rotated, "expected_rotate")
        expected_matrix = [[1, 2, 3], [1, 2, 3], [1, 2, 3]]
        expected_rotate = [[1, 2, 3], [1, 2, 3], [1, 2, 3]]
        matrix, rotated = self.make_matrix_and_expected_rotate(3, 4)
        self.assertEqual(expected_matrix, matrix, "expected_matrix")
        self.assertEqual(expected_rotate, rotated, "expected_rotate")
        expected_matrix = [[1, 2, 3, 4], [1, 2, 3, 4], [1, 2, 3, 4], [1, 2, 3, 4]]
        expected_rotate = [[1, 2, 3, 4], [1, 2, 3, 4], [1, 2, 3, 4], [1, 2, 3, 4]]
        matrix, rotated = self.make_matrix_and_expected_rotate(4, 4)
        self.assertEqual(expected_matrix, matrix, "expected_matrix")
        self.assertEqual(expected_rotate, rotated, "expected_rotate")
        expected_matrix = [[1, 2, 3, 4], [1, 2, 3, 4], [1, 2, 3, 4], [1, 2, 3, 4]]
        expected_rotate = [[1, 2, 3, 4], [1, 2, 3, 4], [1, 2, 3, 4], [1, 2, 3, 4]]
        matrix, rotated = self.make_matrix_and_expected_rotate(4, 12)
        self.assertEqual(expected_matrix, matrix, "expected_matrix")
        self.assertEqual(expected_rotate, rotated, "expected_rotate")

        expected_matrix = [[1, 2, 3, 4], [1, 2, 3, 4], [1, 2, 3, 4], [1, 2, 3, 4]]
        expected_rotate = [[4, 4, 4, 4], [3, 3, 3, 3], [2, 2, 2, 2], [1, 1, 1, 1]]
        matrix, rotated = self.make_matrix_and_expected_rotate(4, 9)
        self.assertEqual(expected_matrix, matrix, "expected_matrix")
        self.assertEqual(expected_rotate, rotated, "expected_rotate")


