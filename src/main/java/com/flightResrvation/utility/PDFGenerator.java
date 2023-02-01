  package com.flightResrvation.utility;

import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.flightResrvation.Entity.Reservation;
import com.itextpdf.text.Document;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
@Component
public class PDFGenerator {

	public void generateItinerary(Reservation reservation, String filepath) {
		Document document=new Document();
		
		try {
			
			PdfWriter.getInstance(document,new FileOutputStream(filepath));
			document.open();
			document.add(generateTable(reservation));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private PdfPTable generateTable(Reservation reservation) {
		PdfPTable table=new PdfPTable(2);
		PdfPCell cell;
		cell= new PdfPCell(new Phrase("Flight Itinerary"));
		cell.setColspan(2);
		table.addCell(cell);
		
		cell=new PdfPCell(new Phrase("Flight Details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("Departure City");
		table.addCell(reservation.getFlight().getDepartureCity());
		
		table.addCell("Arrival City");
		table.addCell(reservation.getFlight().getArrivalCity());
		
		table.addCell("Flight Number");
		table.addCell(reservation.getFlight().getFlightNumber());
		
		table.addCell("Operting  Airlines");
		table.addCell(reservation.getFlight().getOpertingAirlines());
		
		table.addCell("Departure Date");
		table.addCell(reservation.getFlight().getDateOfDeparture().toString());
		
		table.addCell("Departure time");
		table.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());
		
		table.addCell("First Name");
		table.addCell(reservation.getPassenger().getFirstName());
		table.addCell("Last Name");
		table.addCell(reservation.getPassenger().getLastName());
		table.addCell("Middle Name");
		table.addCell(reservation.getPassenger().getMiddleName());
		table.addCell("Email");
		table.addCell(reservation.getPassenger().getEmail());
		table.addCell("Mobile Number");
		table.addCell(reservation.getPassenger().getPhone());
		return table;
	}

}
