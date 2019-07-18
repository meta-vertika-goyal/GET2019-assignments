import static org.junit.Assert.*;

import org.junit.Test;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  TestSplitArrayParameterized.class,
  TestMaxMirrorParameterized.class,
  TestNumberOfClumpsParameterized.class
})
public class FeatureTestSuiteParameterised {
  // the class remains empty,
  // used only as a holder for the above annotations
}