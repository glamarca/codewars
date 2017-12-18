fn comp(a: Vec<i64>, b: Vec<i64>) -> bool {
    println!("[{}]", a.iter().fold(String::new(), |acc, &num| acc + &num.to_string() + ", "));
    println!("[{}]", b.iter().fold(String::new(), |acc, &num| acc + &num.to_string() + ", "));
    let mut ma = a.iter().map(|x| x*x).collect::<Vec<_>>();
    ma.sort();
    let mut mb = b;
    mb.sort();
    println!("[{}]", ma.iter().fold(String::new(), |acc, &num| acc + &num.to_string() + ", "));
    println!("[{}]", mb.iter().fold(String::new(), |acc, &num| acc + &num.to_string() + ", "));
    ma == mb
}

#[test]
fn tests_comp() {

    let a1 = vec![121, 144, 19, 161, 19, 144, 19, 11];
    let a2 = vec![11*11, 121*121, 144*144, 19*19, 161*161, 19*19, 144*144, 19*19];
    testing_equals(comp(a1, a2), true);
    let a1 = vec![121, 144, 19, 161, 19, 144, 19, 11];
    let a2 = vec![11*21, 121*121, 144*144, 19*19, 161*161, 19*19, 144*144, 19*19];
    testing_equals(comp(a1, a2), false);
    let a1 = vec![121, 144, 19, 161, 19, 144, 19, 11];
    let a2 = vec![121, 14641, 20736, 36100, 25921, 361, 20736, 361];
    testing_equals(comp(a1, a2), false);
    let a1 = vec![2, 2, 3];
    let a2 = vec![4, 9, 9];
    testing_equals(comp(a1, a2), false);
    let a1 = vec![-121, -144, 19, -161, 19, -144, 19, -11, ];
    let a2 = vec![121, 14641, 20736, 361, 25921, 361, 20736, 361, ];
    testing_equals(comp(a1, a2), true);

    pub fn testing_equals(a : bool , b : bool) -> (){
        assert_eq!(a,b)
    }
}