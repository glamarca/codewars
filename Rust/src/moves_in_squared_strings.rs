pub mod moves_in_squared_string {

    pub fn vert_mirror(text: String) -> String {
        let split_text : Vec<String> = text.split("\n").map(String::from).collect();
        let vect_result = split_text.iter().map(|line|line.clone().chars().rev().collect::<String>()).collect::<Vec<_>>();
        vect_result.join("\n")
    }

    pub fn hor_mirror(text: String) -> String {
        let mut split_text : Vec<String> = text.split("\n").map(String::from).collect();
        split_text.reverse();
        split_text.join("\n")
    }

    pub fn make_move<F>(text : String, funct : F)  -> String where F: Fn(String) -> String {
        funct(text)
    }

    #[test]
    fn text_make_move(){
        let s = String::from("abcd\nefgh\nijkl\nmnop");
        testing_equals(make_move(s, vert_mirror), String::from("dcba\nhgfe\nlkji\nponm"));
        let s = String::from("abcd\nefgh\nijkl\nmnop");
        testing_equals(make_move(s, hor_mirror), String::from("mnop\nijkl\nefgh\nabcd"));
    }

    fn testing_equals(a : String , b : String) -> (){
        assert_eq!(a,b)
    }
}