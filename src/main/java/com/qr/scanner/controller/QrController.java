package com.qr.scanner.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qr.scanner.util.QRCodeGenerator;

@RestController
public class QrController {

	private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";

	@GetMapping("/generateqr")
	public @ResponseBody byte[] getQRCode(@RequestParam("text") String text) {

		byte[] image = new byte[0];
		try {

			// Generate and Return Qr Code in Byte Array
			image = QRCodeGenerator.getQRCodeImage(text, 250, 250);

			// Generate and Save Qr Code Image in static/image folder
			QRCodeGenerator.generateQRCodeImage(text, 250, 250, QR_CODE_IMAGE_PATH);

		} catch (Exception e) {
			e.printStackTrace();
		}
		// Convert Byte Array into Base64 Encode String
		return image;

	}

}
