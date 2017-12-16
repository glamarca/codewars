pub mod highest_and_low{

    pub fn high_and_low(s: &str) -> String {
       format!("{} {}",
               s.split_whitespace().map(|x|x.parse::<i64>().unwrap()).max().unwrap(),
               s.split_whitespace().map(|x|x.parse::<i64>().unwrap()).min().unwrap()
       )
    }
}