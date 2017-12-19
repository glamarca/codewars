object SingleCharPalindromes {

    def solve(s : String) : String = {

      def solve_acc(s : String, idx_debut : Int,idx_fin : Int, is_plus_one : Boolean) : (Boolean, Boolean) = {
        if (idx_debut >= idx_fin) {
          (true, is_plus_one)
        } else {
          if (s.charAt(idx_debut) == s.charAt(idx_fin)) {
            solve_acc(s, idx_debut + 1, idx_fin - 1, is_plus_one)
          } else if (is_plus_one) {
            (false, is_plus_one)
          } else {
            (solve_acc(s.substring(0, idx_debut).concat(s.substring(idx_debut+1)), 0, s.length - 2, true)._1
             || solve_acc(s.substring(0, idx_fin).concat(s.substring(idx_fin+1)), 0, s.length - 2, true)._1, true)
          }
        }
      }

      if (s == null){
        "not possible"
      } else {
        val solved = solve_acc(s, 0, s.length - 1, false)
        if(solved._1 && solved._2){
          "remove one"
        } else if(solved._1){
          "OK"
        } else {
          "not possible"
        }
      }
    }

}
