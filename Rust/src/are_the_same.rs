
fn comp(a: Vec<i64>, b: Vec<i64>) -> bool {
    println!("[{}]", a.iter().fold(String::new(), |acc, &num| acc + &num.to_string() + ", "));
    println!("[{}]", b.iter().fold(String::new(), |acc, &num| acc + &num.to_string() + ", "));
    a.iter().filter_map(|x| match b.contains(&(x*x)) { false => Some(x), _ => None }).next() == None &&
        b.iter().filter_map(|x| match a.iter().map(|x| x*x).collect::<Vec<_>>().contains(&x) { false => Some(x), _ => None }).next() == None
}


fn testing(a: Vec<i64>, b: Vec<i64>, exp: bool) -> () {
    assert_eq!(comp(a, b), exp)
}

#[test]
fn tests_comp() {

    let a1 = vec![121, 144, 19, 161, 19, 144, 19, 11];
    let a2 = vec![11*11, 121*121, 144*144, 19*19, 161*161, 19*19, 144*144, 19*19];
    testing(a1, a2, true);
    let a1 = vec![121, 144, 19, 161, 19, 144, 19, 11];
    let a2 = vec![11*21, 121*121, 144*144, 19*19, 161*161, 19*19, 144*144, 19*19];
    testing(a1, a2, false);
    let a1 = vec![121, 144, 19, 161, 19, 144, 19, 11];
    let a2 = vec![121, 14641, 20736, 36100, 25921, 361, 20736, 361];
    testing(a1, a2, false);
    let a1 = vec![2, 2, 3];
    let a2 = vec![4, 9, 9];
    testing(a1, a2, false);
}