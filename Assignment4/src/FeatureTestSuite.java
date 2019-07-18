import static org.junit.Assert.*;

import org.junit.Test;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  TestSplitArray.class,
  TestMaxMirror.class,
  TestFixXY.class,
  TestNumberOfClumps.class
})
public class FeatureTestSuite {
  // the class remains empty,
  // used only as a holder for the above annotations
}