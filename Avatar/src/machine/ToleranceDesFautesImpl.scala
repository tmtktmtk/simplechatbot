package machine

object HammingMethod extends ToleranceDesFautes {

  def check(rq: Array[String], dsb: Array[Array[String]]): Array[String] = {
    var res = rq
    for (i <- 0 to rq.length - 1) {
      for (j <- 0 to dsb.length - 1) {
        for (k <- 0 to dsb(j).length - 1) {
          val hd = HammingDistance(rq(i), dsb(j)(k))
          if (hd == 0 || hd == 1) {
            res(i) = dsb(j)(k)
          }
        }
      }
    }
    res
  }  
  
  private def HammingDistance(s1: String, s2: String): Int = {
    val length = Math.min(s1.length() - 1, s2.length() - 1)
    if (Math.abs(s1.length() - s2.length()) > 1) -1 else {
      var count = 0
      for (i <- 0 to length) {
        if (s1.charAt(i).equals(s2.charAt(i))) count = count + 1
      }
      Math.abs(count - (length + 1))
    }
  }  
  
}

object LevenshteinMethod extends ToleranceDesFautes {

  def check(rq: Array[String], dsb: Array[Array[String]]): Array[String] = {
    var res = rq
    for (i <- 0 to rq.length - 1) {
      for (j <- 0 to dsb.length - 1) {
        for (k <- 0 to dsb(j).length - 1) {
          val hd = LevenshteinDistance(rq(i), dsb(j)(k))
          if (hd == 0 || hd == 1) {
            res(i) = dsb(j)(k)
          }
        }
      }
    }
    res
  }  
  
    
   def LevenshteinDistance (s1: String, s2: String) : Int = {
    
    def minimum(i1: Int, i2: Int, i3: Int) = Math.min(Math.min(i1, i2), i3)

    val dist = Array.ofDim[Int](s1.length + 1, s2.length + 1)

    for (idx <- 0 to s1.length) dist(idx)(0) = idx
    for (jdx <- 0 to s2.length) dist(0)(jdx) = jdx

    for (idx <- 1 to s1.length; jdx <- 1 to s2.length)
      dist(idx)(jdx) = minimum (
        dist(idx-1)(jdx  ) + 1,
        dist(idx  )(jdx-1) + 1,
        dist(idx-1)(jdx-1) + (if (s1(idx-1) == s2(jdx-1)) 0 else 1)
      )

    dist(s1.length)(s2.length)   
    
  }
  
}
