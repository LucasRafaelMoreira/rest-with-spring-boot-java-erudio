package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsupportedMathOperationException;

@RestController
public class MathController {

	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
            ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }
	
	@RequestMapping(value="/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sub(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
            ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

	
	@RequestMapping(value="/mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double mult(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
            ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

	
	@RequestMapping(value="/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double div(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
            ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }
	
	@RequestMapping(value="/med/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double med(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
            ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        
        Double result = (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
        return result;
    }

	@RequestMapping(value="/raiz/{numberOne}", method=RequestMethod.GET)
    public Double raiz(
            @PathVariable("numberOne") String numberOne
            ) throws Exception {
        if (!isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        
        Double result = Math.sqrt(convertToDouble(numberOne));
        
        return result;
	}


	private Double convertToDouble(String strNumber) {
		if(strNumber == null) {
			return 0D;
		}
		//BR 10,25  US 10.25
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(number)) {
			return Double.parseDouble(number);
		}
		
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		// TODO Auto-generated method stub
		if(strNumber == null) {
			return false;
		}
		
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
		
		
		
		
	}

}
