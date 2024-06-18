package unit

import org.scalatest.funsuite.AnyFunSuite
import com.adventOfCode.configuration.Settings

class TestSetUp extends AnyFunSuite {
    test("Sum of two values") {
        assert(1 + 1 == 2, "Sum of two values")
    }

    test("ConfigSetup") {
        val conf = new Settings();
        assert("input" == conf.getInputDir());
        assert(conf.getInputDir() != "")
    }

    test("New Config") {
        val c = new Settings("in", "out");
        assert(c.getInputDir() == "in")
        assert(c.getOutputDir() == "out")
    }

}