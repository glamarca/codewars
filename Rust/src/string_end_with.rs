pub mod string_end_with {

    fn solution(word: &str, ending: &str) -> bool {
        word.ends_with(ending)
    }

    #[test]
    fn test_solution(){
        assert_eq!(solution("abc", "bc"), true);
        assert_eq!(solution("abc", "d"), false);
    }
}