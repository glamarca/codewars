import org.scalatest.FunSuite

class NPointCrossoverTest extends FunSuite {
  val npc = NPointCrossover
  test("testTruc") {
    assert(npc.truc(5) == 25)
  }

  test("Crossover liste xs et/ou ys vide ou xs.length != ys.length"){
    assert(npc.crossover(5::Nil,Nil, 5::Nil) == (Nil, Nil))
    assert(npc.crossover(5::Nil,5::Nil, Nil) == (Nil, Nil))
    assert(npc.crossover(5::Nil,Nil, Nil) == (Nil, Nil))
    assert(npc.crossover(5::Nil,5::Nil, 6::(7::Nil)) == (Nil, Nil))
  }

  test("Crossover ns.length > xs.length"){
    assert(npc.crossover(6::(7::Nil), 5::Nil,5::Nil) == ( 5::Nil,5::Nil))
  }

  test("Crossover liste n vide ou null "){
    assert(npc.crossover(Nil,5::Nil, 5::Nil) == (5::Nil, 5::Nil))
    assert(npc.crossover(null,5::Nil, 5::Nil) == (5::Nil, 5::Nil))
  }

  test("Crossover liste n 1 element"){
    assert(npc.crossover(List(1),List('a','b','c'),List('x','y','z')) == (List('a','y','z'), List('x','b','c')))
    assert(npc.crossover(List(2), List('x','x','x','x','x','x'),
      List('y','y','y','y','y','y')) == (List('x','x','y','y','y','y'), List('y','y','x','x','x','x')))
  }

  test("Crossover liste n  n elements"){
    assert(npc.crossover(List(1,3), List('x','x','x','x','x','x'),
      List('y','y','y','y','y','y')) == (List('x','y','y','x','x','x'), List('y','x','x','y','y','y')))
  }

  test("Crossover liste n contient plusieur fois le même nombre"){
    assert(npc.crossover(List(2,2), List('x','x','x','x','x','x'),
      List('y','y','y','y','y','y')) == (List('x','x','y','y','y','y'), List('y','y','x','x','x','x')))
    assert(npc.crossover(List(3,1,1,3), List('x','x','x','x','x','x'),
      List('y','y','y','y','y','y')) == (List('x','y','y','x','x','x'), List('y','x','x','y','y','y')))
  }

}
