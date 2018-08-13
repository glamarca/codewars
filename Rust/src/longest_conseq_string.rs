pub mod longest_conseq_string {
    pub fn longest_consec(strarr: Vec<&str>, k: usize) -> String {
        // your code
    }

    fn testing(strarr: Vec<&str>, k: usize, exp: &str) -> () {
        assert_eq!(&longest_consec(strarr, k), exp)
    }

    #[test]
    fn basics_longest_consec() {
        testing(vec!["zone", "abigail", "theta", "form", "libe", "zas"], 2, "abigailtheta");
        testing(vec!["ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"], 1,
                "oocccffuucccjjjkkkjyyyeehh");
        testing(vec![], 3, "");
        testing(vec!["it","wkppv","ixoyx", "3452", "zzzzzzzzzzzz"], 3, "ixoyx3452zzzzzzzzzzzz");
        testing(vec!["it","wkppv","ixoyx", "3452", "zzzzzzzzzzzz"], 15, "");
        testing(vec!["it","wkppv","ixoyx", "3452", "zzzzzzzzzzzz"], 0, "");
    }
}