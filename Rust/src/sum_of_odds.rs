pub mod sum_off_odds {
    pub fn row_sum_odd_numbers(idx: i64) -> i64 {
        let mut result = idx*(idx-1) + 1;
        for x in 1..idx-1 {
            print!("{}", result);
            result = result + (result + 2);
        }   print!("{}", result);
        result
    }


    #[test]
    fn test_row_sum_odd_numbers(){
        testing(1, row_sum_odd_numbers(1));
        testing(8, row_sum_odd_numbers(2));
        testing(27, row_sum_odd_numbers(3));
        //testing(64, row_sum_odd_numbers(4));
    }

    fn testing(a: i64, b: i64){
        assert_eq!(a, b)
    }
}
