package org.prgms.kdtspringweek1.voucher.entity;

import org.prgms.kdtspringweek1.voucher.exception.ExceptionCode;

import java.text.MessageFormat;
import java.util.UUID;

public class PercentDiscountVoucher implements Voucher {
    private final UUID voucherId;
    private final long percent;
    private final static VoucherType voucherType = VoucherType.PERCENT_DISCOUNT;

    public static PercentDiscountVoucher createWithPercent(long percent) {
        return new PercentDiscountVoucher(percent);
    }

    public static PercentDiscountVoucher createWithIdAndPercent(UUID voucherId, long percent) {
        return new PercentDiscountVoucher(voucherId, percent);
    }

    private PercentDiscountVoucher(long percent) {
        if (percent > 0 && percent <= 100) {
            this.voucherId = UUID.randomUUID();
            this.percent = percent;
        } else {
        }
    }

    private PercentDiscountVoucher(UUID voucherId, long percent) {
        this.voucherId = voucherId;
        this.percent = percent;
    }

    @Override
    public UUID getVoucherId() {
        return voucherId;
    }

    @Override
    public String toString() {
        return "PercentDiscountVoucher{" +
                "voucherId=" + voucherId +
                ", percent=" + percent +
                '}';
    }

    @Override
    public void printVoucherInfo() {
        System.out.println(MessageFormat.format("Voucher Type: {0}", voucherType.getName()));
        System.out.println(MessageFormat.format("Voucher Id: {0}", voucherId));
        System.out.println(MessageFormat.format("Percent Discount: {0}", percent));
    }

    @Override
    public VoucherType getVoucherType() {
        return voucherType;
    }

    @Override
    public long getDiscountValue() {
        return percent;
    }
}