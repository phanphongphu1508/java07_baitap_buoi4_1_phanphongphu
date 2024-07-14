package bai_tap;
import java.util.Scanner;
import java.text.DecimalFormat;

public class baitap_caudieukien {
	public static void main(String[] args) {
		
		String tenHangHoa;
		final double giamGia8PhanTram = 8.0;
		final double giamGia12PhanTram = 12.0;
		double donGia;
		double tienGiamGia;
		double thanhTien;
		double tongTienChuaGiamGia;
		int soLuong;
		
		// Cho phép nhập từ bàn phím
		Scanner banPhim = new Scanner(System.in);
		
		// Nhập vào tên mặt hàng, số lượng, đơn giá
		System.out.println("VUI LÒNG NHẬP THÔNG TIN ĐƠN HÀNG ");
		System.out.print("Tên hàng hóa: ");
		tenHangHoa = banPhim.nextLine();
		
		// Cảnh báo và cho nhập lại nếu số lượng nhỏ hơn 1
		do {
			System.out.print("Số lượng: ");
			soLuong = banPhim.nextInt();
			if(soLuong < 1) {
				System.out.println("Số lượng phải lớn hơn hoặc bằng 1. Vui lòng nhập lại! ");
			}
		} while(soLuong < 1);
		
		// cảnh báo và cho nhập lại nếu đơn giá nhỏ hơn 1
		do {
			System.out.print("Đơn giá: ");
			donGia = banPhim.nextDouble();
			if(donGia < 1) {
				System.out.println("Đơn giá phải lớn hơn hoặc bằng 1. Vui lòng nhập lại! ");
			}
		} while(donGia < 1);
		
		// Tổng tiền trước khi giảm giá
		tongTienChuaGiamGia = soLuong * donGia;
		
		if(soLuong >= 50 && soLuong <= 100) {
			tienGiamGia = (giamGia8PhanTram / 100 ) * tongTienChuaGiamGia;
		}
		else if (soLuong > 100) {
			tienGiamGia = (giamGia12PhanTram / 100 ) * tongTienChuaGiamGia;
		}
		else {
			tienGiamGia = 0;
		}
		// Tổng tiền sau khi giảm giá
		thanhTien = tongTienChuaGiamGia - tienGiamGia;
		
		// Định dạng đơn giá VND
		DecimalFormat dinhDangDonGia = new DecimalFormat("#,##0");
        String donGiaTienVND = dinhDangDonGia.format(donGia);
        
        // Định dạng số tiên giảm giá VND
		DecimalFormat dinhDangTienGiamGia = new DecimalFormat("#,##0");
        String giamGiaTienVND = dinhDangTienGiamGia.format(tienGiamGia);
    
        // Định dạng thành tiền VND
		DecimalFormat dinhDangThanhTien = new DecimalFormat("#,##0");
        String ThanhTienVND = dinhDangThanhTien.format(thanhTien);
		
		banPhim.close();
		
		// Xuất ra màn hình đơn hàng
		System.out.println("ĐƠN HÀNG CỦA BẠN");
		System.out.println("Tên hàng hóa: " + tenHangHoa);
		System.out.println("Số lượng: " + soLuong);
		System.out.println("Đơn giá: " + donGiaTienVND + "đ");
		System.out.println("Số tiền đã giảm giá: " + giamGiaTienVND + "đ");
		System.out.println("Thành tiền: " + ThanhTienVND + "đ");

	}
}
