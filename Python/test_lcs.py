from unittest import TestCase
from longest_common_subsequence import lcs


class TestLcs(TestCase):

    def test_if_one_string_is_empty(self):
        self.assertEqual("", lcs("", "xxxx"), "If one string should return empty string")
        self.assertEqual("", lcs("xxx", ""), "If one string should return empty string")

    def test_if_same_strings(self):
        self.assertEqual("abc", lcs("abc", "abc"), "If strings are equals should return one of the strings")
        self.assertEqual("xxx", lcs("xxx", "xxx"), "If strings are equals should return one of the strings")

    def test_subsequence_of_one_char(self):
        self.assertEqual("b", lcs("abc", "b"), "b should be the subsequence")
        self.assertEqual("", lcs("xxx", "w"), "No subsequence return empty string")

    def test_if_no_subsequence(self):
        self.assertEqual("", lcs("abc", "def"), "If none of the sequence match the string should return empty string")
        self.assertEqual("", lcs("xxx", "wzuml"), "If none of the sequence match the string should return empty string")

    def test_subsequence(self):
        self.assertEqual("abc", lcs("abcdef", "abc"), "Should be a subsequence")
        self.assertEqual("acf", lcs("abcdef", "acf"), "Should be a subsequence")
        self.assertEqual("12356", lcs("132535365", "123456789"), "Should be a subsequence")
        self.assertEqual("3412", lcs("1234", "3412"), "Should be a subsequence")
        self.assertEqual("final", lcs("finaltet", "zzzfinallyzzz"), "Should be a subsequence")