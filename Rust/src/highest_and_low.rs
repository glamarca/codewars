pub mod highest_and_low{

    pub fn high_and_low(s: &str) -> String {
       format!("{} {}",
               s.split_whitespace().map(|x|x.parse::<i64>().unwrap()).max().unwrap(),
               s.split_whitespace().map(|x|x.parse::<i64>().unwrap()).min().unwrap()
       )
    }

    #[test]
    fn test_high_and_low(){
        testing_equals(String::from("5 1"), high_and_low("1 2 3 4 5"));
        testing_equals(String::from("5 -3"), high_and_low("1 2 -3 4 5"));
        testing_equals(String::from("9 -5"), high_and_low("1 9 3 4 -5"));
    }

    pub fn testing_equals(a : String , b : String) -> (){
        assert_eq!(a,b)
    }
}