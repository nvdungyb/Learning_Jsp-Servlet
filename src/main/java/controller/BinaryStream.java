package controller;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;

@WebServlet("/binary")
public class BinaryStream extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse res) throws IOException {
        // Set content type.
        res.setContentType("image/jpeg");

        // Get the ServletOutputStream. Để ghi dữ liệu và trả về client.
        ServletOutputStream outPutStream = res.getOutputStream();

        // 1- Open stream to the image data.
        InputStream inputStream = getServletContext().getResourceAsStream("/images/Idol.jpeg");

        // 2- Define byte array to hold the image data.
        byte[] imageBytes = new byte[1024];

        // 3- Read the image data from the input stream.
        int bytesRead = 0;
        while ((bytesRead = inputStream.read(imageBytes)) != -1) {
            outPutStream.write(imageBytes, 0, bytesRead);
        }

        // tác dụng của flush() đảm bảo rằng tất cả các dữ liệu đã được ghi vào ServletOutputStream.
        outPutStream.flush();

        // 4- Close the stream.
        inputStream.close();
        outPutStream.close();
    }
}

// Sử dụng các luồng (Streams) để hạn chế sử dụng bộ nhớ và tối ưu hóa hiệu xuất.