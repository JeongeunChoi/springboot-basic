package org.prgms.kdtspringweek1.voucher.repository;

import org.prgms.kdtspringweek1.voucher.entity.Voucher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Profile("dev")
public class MemoryVoucherRepository implements VoucherRepository {
    private final Map<UUID, Voucher> vouchers = new ConcurrentHashMap<>(); // 동시성을 막기 위한 자료구조
    private final static Logger logger = LoggerFactory.getLogger(MemoryVoucherRepository.class);

    @Override
    public Voucher save(Voucher voucher) {
        vouchers.put(voucher.getVoucherId(), voucher);
        logger.info("Success to save {} -> {} {} discount",
                voucher.getVoucherType().getName(),
                voucher.getDiscountValue(),
                voucher.getVoucherType().getUnit());
        return voucher;
    }

    @Override
    public List<Voucher> findAllVouchers() {
        List<Voucher> allVouchers = new ArrayList<>(vouchers.values());
        logger.info("Success to findAllVouchers");
        return allVouchers;
    }
}
