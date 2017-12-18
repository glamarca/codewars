from unittest import TestCase

from single_char_palindromes import is_a_pallindrom_maybe_minus_one, now_is_a_pallindrom, solve


class TestNowIsAPallindrom(TestCase):

    def test_now_is_a_pallindrom(self):
        s = "abba"
        self.assertTrue(now_is_a_pallindrom(s, 0, len(s)-1))

    def test_now_is_not_a_pallindrom(self):
        s_false = "abbaa"
        self.assertFalse(now_is_a_pallindrom(s_false, 0, len(s_false)-1))


class TestIsAPallindromMabeMinusOne(TestCase):

    def test_is_a_simple_pallindrom(self):
        simple_s = "abba"
        message = is_a_pallindrom_maybe_minus_one(simple_s, 0, len(simple_s)-1)
        self.assertEqual(message, "OK")

    def test_is_a_pallindrom_minus_one(self):
        minus_one_s = "abbaa"
        message = is_a_pallindrom_maybe_minus_one(minus_one_s, 0, len(minus_one_s)-1)
        self.assertEqual(message, "remove one")

    def test_is_not_a_pallindrom_at_all(self):
        not_s = "abbaab"
        message = is_a_pallindrom_maybe_minus_one(not_s, 0, len(not_s)-1)
        self.assertEqual(message, "not possible")


class TestAll(TestCase):

    def test_all(self):
        self.assertEqual(solve("abba"), "OK")
        self.assertEqual(solve("abbaa"), "remove one")
        self.assertEqual(solve("abbaab"), "not possible")
        self.assertEqual(solve("madmam"), "remove one")
        self.assertEqual(solve("raydarm"), "not possible")
        self.assertEqual(solve("hannah"), "OK")
